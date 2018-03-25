package ${basePackage}.${servicePackage};

import ${basePackage}.${daoPackage}.${doNameUpperCamel}Dao;
import ${basePackage}.${doPackage}.${doNameUpperCamel};
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.company.project.common.service.BaseService;
import javax.annotation.Resource;


/**
* ${tableComment}Service
* @author ${author}
* @date ${date}
*/
@Service
@Transactional
public class ${doNameUpperCamel}Service extends BaseService<${doNameUpperCamel}Dao, ${doNameUpperCamel}> {
    @Resource
    private ${doNameUpperCamel}Dao ${doNameUpperCamel ? uncap_first}Dao;

    @Transactional(readOnly = false)
	public void save(${doNameUpperCamel} ${doNameUpperCamel ? uncap_first}) {
		if (null == ${doNameUpperCamel ? uncap_first}.getId()){
            super.insert(${doNameUpperCamel ? uncap_first});
		}else{
			super.update(${doNameUpperCamel ? uncap_first});
		}
	}
}
