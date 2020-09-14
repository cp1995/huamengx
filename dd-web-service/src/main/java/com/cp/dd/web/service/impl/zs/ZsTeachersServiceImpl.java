package com.cp.dd.web.service.impl.zs;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.entity.zs.ZsTeachers;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.zs.ZsTeachersMapper;
import com.cp.dd.common.util.ExcelUtil;
import com.cp.dd.web.form.zs.ZsTeachersForm;
import com.cp.dd.web.service.zs.IZsTeachersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-14
 */
@AllArgsConstructor
@Service
public class ZsTeachersServiceImpl extends ServiceImpl<ZsTeachersMapper, ZsTeachers> implements IZsTeachersService {

    @Override
    public void save(ZsTeachersForm zsTeachersForm) {
        ZsTeachers zsTeachers = new ZsTeachers();
        ZsTeachers zsTeachers1 = this.baseMapper.selectOne(Wrappers.<ZsTeachers>lambdaQuery()
            .eq(ZsTeachers::getName,zsTeachersForm.getName())
        );
        if(zsTeachers1 != null){
            throw new ApiException("该姓名已存在");
        }
        BeanUtils.copyProperties(zsTeachersForm,zsTeachers);
        zsTeachers.setRzTime(LocalDate.now());
        this.baseMapper.insert(zsTeachers);
    }

    @Override
    public void importItem(MultipartFile file) {
        if (file.isEmpty()) {
            throw new ApiException("文件上传失败");
        }
        // 获取 Excel 工作簿
        Workbook workbook = ExcelUtil.getWorkbookFromFile(file);
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            ZsTeachers zsTeachers = new ZsTeachers();
            zsTeachers.setName(row.getCell(0).getStringCellValue());
            zsTeachers.setSex(row.getCell(1).getStringCellValue());
            zsTeachers.setMobile(row.getCell(2).getStringCellValue());
            zsTeachers.setIdCard(row.getCell(3).getStringCellValue());
            zsTeachers.setRzTime(LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(row.getCell(5).getStringCellValue())));
            zsTeachers.setDept(row.getCell(6).getStringCellValue());
            this.baseMapper.insert(zsTeachers);
        }
    }

    @Override
    public void export(HttpServletResponse response, HttpServletRequest request, String name) {
        List<ZsTeachers> list = baseMapper.selectList(Wrappers.<ZsTeachers>lambdaQuery()
                .like(StringUtils.isNotBlank(name),ZsTeachers::getName, name)
        );
        String[] titles = new String[]{"姓名","性别","电话","身份证","首次认证时间","所属机构"};
        String[] fields = {"name","sex","mobile","idCard","rzTime","dept"};
        // 转化器
        Map<String, ExcelUtil.Converter> converters = new HashMap<>(16);
        converters.put("rzTime", (ExcelUtil.Converter<LocalDate>) rzTime -> rzTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        ExcelUtil.exportExcel( "认证师资.xlsx", titles, fields, list, response, converters);
    }


}
