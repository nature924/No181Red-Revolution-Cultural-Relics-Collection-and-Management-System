
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 文物
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wenwu")
public class WenwuController {
    private static final Logger logger = LoggerFactory.getLogger(WenwuController.class);

    private static final String TABLE_NAME = "wenwu";

    @Autowired
    private WenwuService wenwuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GongzuoService gongzuoService;//工作人员
    @Autowired
    private NewsService newsService;//公告资讯
    @Autowired
    private WenwuCollectionService wenwuCollectionService;//文物收藏
    @Autowired
    private WenwuLiuyanService wenwuLiuyanService;//文物留言
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("工作人员".equals(role))
            params.put("gongzuoId",request.getSession().getAttribute("userId"));
        params.put("wenwuDeleteStart",1);params.put("wenwuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = wenwuService.queryPage(params);

        //字典表数据转换
        List<WenwuView> list =(List<WenwuView>)page.getList();
        for(WenwuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WenwuEntity wenwu = wenwuService.selectById(id);
        if(wenwu !=null){
            //entity转view
            WenwuView view = new WenwuView();
            BeanUtils.copyProperties( wenwu , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(wenwu.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WenwuEntity wenwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wenwu:{}",this.getClass().getName(),wenwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            wenwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WenwuEntity> queryWrapper = new EntityWrapper<WenwuEntity>()
            .eq("yonghu_id", wenwu.getYonghuId())
            .eq("wenwu_name", wenwu.getWenwuName())
            .eq("wenwu_types", wenwu.getWenwuTypes())
            .eq("zan_number", wenwu.getZanNumber())
            .eq("cai_number", wenwu.getCaiNumber())
            .in("wenwu_yesno_types", new Integer[]{1,2})
            .eq("wenwu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenwuEntity wenwuEntity = wenwuService.selectOne(queryWrapper);
        if(wenwuEntity==null){
            wenwu.setWenwuClicknum(1);
            wenwu.setWenwuYesnoTypes(1);
            wenwu.setWenwuDelete(1);
            wenwu.setInsertTime(new Date());
            wenwu.setCreateTime(new Date());
            wenwuService.insert(wenwu);
            return R.ok();
        }else {
            if(wenwuEntity.getWenwuYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(wenwuEntity.getWenwuYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WenwuEntity wenwu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wenwu:{}",this.getClass().getName(),wenwu.toString());
        WenwuEntity oldWenwuEntity = wenwuService.selectById(wenwu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            wenwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(wenwu.getWenwuPhoto()) || "null".equals(wenwu.getWenwuPhoto())){
                wenwu.setWenwuPhoto(null);
        }

            wenwuService.updateById(wenwu);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody WenwuEntity wenwuEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,wenwuEntity:{}",this.getClass().getName(),wenwuEntity.toString());

        WenwuEntity oldWenwu = wenwuService.selectById(wenwuEntity.getId());//查询原先数据

//        if(wenwuEntity.getWenwuYesnoTypes() == 2){//通过
//            wenwuEntity.setWenwuTypes();
//        }else if(wenwuEntity.getWenwuYesnoTypes() == 3){//拒绝
//            wenwuEntity.setWenwuTypes();
//        }
        wenwuService.updateById(wenwuEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WenwuEntity> oldWenwuList =wenwuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<WenwuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            WenwuEntity wenwuEntity = new WenwuEntity();
            wenwuEntity.setId(id);
            wenwuEntity.setWenwuDelete(2);
            list.add(wenwuEntity);
        }
        if(list != null && list.size() >0){
            wenwuService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<WenwuEntity> wenwuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            WenwuEntity wenwuEntity = new WenwuEntity();
//                            wenwuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            wenwuEntity.setWenwuUuidNumber(data.get(0));                    //文物编号 要改的
//                            wenwuEntity.setWenwuName(data.get(0));                    //文物名称 要改的
//                            wenwuEntity.setWenwuPhoto("");//详情和图片
//                            wenwuEntity.setWenwuTypes(Integer.valueOf(data.get(0)));   //文物类型 要改的
//                            wenwuEntity.setWenwuClicknum(Integer.valueOf(data.get(0)));   //文物热度 要改的
//                            wenwuEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            wenwuEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            wenwuEntity.setWenwuContent("");//详情和图片
//                            wenwuEntity.setWenwuYesnoTypes(Integer.valueOf(data.get(0)));   //信息审核 要改的
//                            wenwuEntity.setWenwuYesnoText(data.get(0));                    //审核结果 要改的
//                            wenwuEntity.setWenwuDelete(1);//逻辑删除字段
//                            wenwuEntity.setInsertTime(date);//时间
//                            wenwuEntity.setCreateTime(date);//时间
                            wenwuList.add(wenwuEntity);


                            //把要查询是否重复的字段放入map中
                                //文物编号
                                if(seachFields.containsKey("wenwuUuidNumber")){
                                    List<String> wenwuUuidNumber = seachFields.get("wenwuUuidNumber");
                                    wenwuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wenwuUuidNumber = new ArrayList<>();
                                    wenwuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wenwuUuidNumber",wenwuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //文物编号
                        List<WenwuEntity> wenwuEntities_wenwuUuidNumber = wenwuService.selectList(new EntityWrapper<WenwuEntity>().in("wenwu_uuid_number", seachFields.get("wenwuUuidNumber")).eq("wenwu_delete", 1));
                        if(wenwuEntities_wenwuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WenwuEntity s:wenwuEntities_wenwuUuidNumber){
                                repeatFields.add(s.getWenwuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [文物编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wenwuService.insertBatch(wenwuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<WenwuView> returnWenwuViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = wenwuCollectionService.queryPage(params1);
        List<WenwuCollectionView> collectionViewsList =(List<WenwuCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(WenwuCollectionView collectionView:collectionViewsList){
            Integer wenwuTypes = collectionView.getWenwuTypes();
            if(typeMap.containsKey(wenwuTypes)){
                typeMap.put(wenwuTypes,typeMap.get(wenwuTypes)+1);
            }else{
                typeMap.put(wenwuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("wenwuTypes",type);
            PageUtils pageUtils1 = wenwuService.queryPage(params2);
            List<WenwuView> wenwuViewList =(List<WenwuView>)pageUtils1.getList();
            returnWenwuViewList.addAll(wenwuViewList);
            if(returnWenwuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = wenwuService.queryPage(params);
        if(returnWenwuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnWenwuViewList.size();//要添加的数量
            List<WenwuView> wenwuViewList =(List<WenwuView>)page.getList();
            for(WenwuView wenwuView:wenwuViewList){
                Boolean addFlag = true;
                for(WenwuView returnWenwuView:returnWenwuViewList){
                    if(returnWenwuView.getId().intValue() ==wenwuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnWenwuViewList.add(wenwuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnWenwuViewList = returnWenwuViewList.subList(0, limit);
        }

        for(WenwuView c:returnWenwuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnWenwuViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = wenwuService.queryPage(params);

        //字典表数据转换
        List<WenwuView> list =(List<WenwuView>)page.getList();
        for(WenwuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WenwuEntity wenwu = wenwuService.selectById(id);
            if(wenwu !=null){

                //点击数量加1
                wenwu.setWenwuClicknum(wenwu.getWenwuClicknum()+1);
                wenwuService.updateById(wenwu);

                //entity转view
                WenwuView view = new WenwuView();
                BeanUtils.copyProperties( wenwu , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(wenwu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody WenwuEntity wenwu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wenwu:{}",this.getClass().getName(),wenwu.toString());
        Wrapper<WenwuEntity> queryWrapper = new EntityWrapper<WenwuEntity>()
            .eq("yonghu_id", wenwu.getYonghuId())
            .eq("wenwu_uuid_number", wenwu.getWenwuUuidNumber())
            .eq("wenwu_name", wenwu.getWenwuName())
            .eq("wenwu_types", wenwu.getWenwuTypes())
            .eq("wenwu_clicknum", wenwu.getWenwuClicknum())
            .eq("zan_number", wenwu.getZanNumber())
            .eq("cai_number", wenwu.getCaiNumber())
            .in("wenwu_yesno_types", new Integer[]{1,2})
            .eq("wenwu_yesno_text", wenwu.getWenwuYesnoText())
            .eq("wenwu_delete", wenwu.getWenwuDelete())
//            .notIn("wenwu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenwuEntity wenwuEntity = wenwuService.selectOne(queryWrapper);
        if(wenwuEntity==null){
            wenwu.setWenwuClicknum(1);
                wenwu.setZanNumber(1);
                wenwu.setCaiNumber(1);
            wenwu.setWenwuYesnoTypes(1);
            wenwu.setWenwuDelete(1);
            wenwu.setInsertTime(new Date());
            wenwu.setCreateTime(new Date());
        wenwuService.insert(wenwu);

            return R.ok();
        }else {
            if(wenwuEntity.getWenwuYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(wenwuEntity.getWenwuYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

