package com.cp.dd.web.service.zs;

import com.cp.dd.common.entity.zs.ZsTeachers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.web.form.zs.ZsTeachersForm;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-14
 */
public interface IZsTeachersService extends IService<ZsTeachers> {

    void  save(ZsTeachersForm zsTeachersForm);

    void importItem(MultipartFile file);

    void export(HttpServletResponse response, HttpServletRequest request, String name);

}
