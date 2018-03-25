package ${basePackage}.${controllerPackage};

import ${basePackage}.${doPackage}.${doNameUpperCamel};
import ${basePackage}.${qoPackage}.${doNameUpperCamel}QO;
import ${basePackage}.${servicePackage}.${doNameUpperCamel}Service;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
* ${tableComment}Controller
* @author ${author}
* @date ${date}
*/
@RestController
@Api(tags = "${tableComment}")
@RequestMapping("${baseRequestMapping}")
public class ${doNameUpperCamel}Controller {
    @Resource
    private ${doNameUpperCamel}Service ${doNameUpperCamel ? uncap_first}Service;

    @PostMapping("/add")
    @ApiOperation(value = "添加${tableComment}", response = ${doNameUpperCamel}.class, notes = "添加${tableComment}")
    public Result add(@RequestBody ${doNameUpperCamel} ${doNameUpperCamel ? uncap_first}) {
        ${doNameUpperCamel ? uncap_first}Service.save(${doNameUpperCamel ? uncap_first});
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除${tableComment}", response = ${doNameUpperCamel}.class, notes = "删除${tableComment}")
	@ApiImplicitParams({
		@ApiImplicitParam(required = true, name = "id", value = "主键ID", paramType = "query", dataType = "long")
	})
    public Result delete(@RequestParam Integer id) {
        ${doNameUpperCamel ? uncap_first}Service.delete(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改${tableComment}", response = ${doNameUpperCamel}.class, notes = "修改${tableComment}")
    public Result update(@RequestBody ${doNameUpperCamel} ${doNameUpperCamel ? uncap_first}) {
        ${doNameUpperCamel ? uncap_first}Service.save(${doNameUpperCamel ? uncap_first});
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    @ApiOperation(value = "查询${tableComment}详情", response = ${doNameUpperCamel}.class, notes = "查询${tableComment}详情")
	@ApiImplicitParams({
		@ApiImplicitParam(required = true, name = "id", value = "主键ID", paramType = "query", dataType = "long")
	})
    public Result detail(@RequestParam Integer id) {
        ${doNameUpperCamel} ${doNameUpperCamel ? uncap_first} = ${doNameUpperCamel ? uncap_first}Service.getById(id);
        return ResultGenerator.genSuccessResult(${doNameUpperCamel ? uncap_first});
    }

    @GetMapping("/listPage")
    @ApiOperation(value = "分页查询${tableComment}", response = ${doNameUpperCamel}.class, notes = "分页查询${tableComment}")
	@ApiImplicitParams({
		@ApiImplicitParam(required = true, name = "pageSize", value = "每页显示数量", paramType = "query", dataType = "int"),
		@ApiImplicitParam(required = true, name = "pageNum", value = "第几页", paramType = "query", dataType = "int")
	})
    public Result listPage(${doNameUpperCamel}QO ${doNameUpperCamel ? uncap_first}QO) {
        PageInfo<${doNameUpperCamel}> p = ${doNameUpperCamel ? uncap_first}Service.findPage(${doNameUpperCamel ? uncap_first}QO);
        return ResultGenerator.genSuccessResult(p);
    }
}
