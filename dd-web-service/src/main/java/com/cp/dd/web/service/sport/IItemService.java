package com.cp.dd.web.service.sport;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.entity.sport.Item;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.vo.sport.ItemVO;
import com.cp.dd.web.form.member.sport.ItemForm;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * <p>
 * 会员信息 服务类
 * </p>
 *
 * @author chengp
 * @date 2019-09-30
 */
public interface IItemService extends IService<Item> {

    Item save (ItemForm itemForm);

    IPage getPage(PageQuery pageQuery, String childName, String phone, String name,String createBy,String parentName, Long areaId);

    IPage getDataPage(PageQuery pageQuery, String childName, String phone, String name,String createBy,Long areaId,Integer sort,String ascOrDesc);

    void export(HttpServletResponse response, HttpServletRequest request, String childName, String phone, String name, String createBy, Long areaId, Integer sort, String ascOrDesc);

    void importItem(MultipartFile file);

    List<ItemVO> getData(String childName, String phone, Long sportId);

    ItemVO detail( Long id);

}


