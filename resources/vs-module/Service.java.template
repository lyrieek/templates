package com.versionsystem.${package}.${module}.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.versionsystem.common.ApplicationErrorCode;
import com.versionsystem.common.ApplicationException;
import com.versionsystem.common.BeanUtils;
import com.versionsystem.common.FilterRequest;
import com.versionsystem.persistence.model.Q${model};
import com.versionsystem.persistence.model.${model};
import com.versionsystem.service.impl.UserService;

import com.versionsystem.${package}.${module}.model.${^module}UI;
import com.versionsystem.${package}.${module}.repo.${^module}Repository;

import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;

/**
 * 
 * @author tian.hao last update in 2017.07.10
 *
 */
@Service
public class ${^module}Service {
	
	
	@Autowired
	private ${^module}Repository repository;
	
	private Logger logger = Logger.getLogger(${^module}Service.class);

	@Autowired
	private UserService userService;

	private String validateBeforeSave(${^module}UI param) {
		${model} vo = repository.findOne(param.getId());
		if (vo != null)
			return "APP3001";
		else
			return null;
	}

	public Page<${^module}UI> page(Pageable pageable) {
		${^module}UI vo = null;
		List<${^module}UI> results = new ArrayList<${^module}UI>();
		Page<${model}> ${module}Page = repository.findAll(pageable);
		List<${model}> ${module}Content = ${module}Page.getContent();
		for (${model} ${module} : ${module}Content) {
			vo = new ${^module}UI();
			BeanUtils.copyProperties(${module}, vo);
			results.add(vo);
		}
		Page<${^module}UI> pageReturn = new PageImpl<${^module}UI>(results, pageable, ${module}Page.getTotalElements());
		return pageReturn;
	}

	public List<${^module}UI> findAll() {
		${^module}UI vo = null;
		List<${^module}UI> results = new ArrayList<${^module}UI>();
		List<${model}> ${module}Page = repository.findAll();
		for (${model} ${module} : ${module}Page) {
			vo = new ${^module}UI();
			BeanUtils.copyProperties(${module}, vo);
			results.add(vo);
		}
		return results;
	}

	@Transactional
	public ${^module}UI save(${^module}UI ${module}) {
		String errorCode = this.validateBeforeSave(${module});
		if (errorCode == null) {

			${^module} result = reverse${^module}(${module});
			result = this.repository.saveAndFlush(result);
			result.setCreateUser(userService.getCurrentUserName());
			result.setCreateDate(new Timestamp(new Date().getTime()));
			result.setLastUpdateUser(userService.getCurrentUserName());
			result.setLastUpdateDate(new Timestamp(new Date().getTime()));
			BeanUtils.copyProperties(result, ${module});
			return ${module};
		} else {
			throw new ApplicationException(new ApplicationErrorCode(errorCode, "Validation Error").toString());
		}
	}

	public ${model} reverse${^module}(${^module}UI rc) {
		${model} ${module} = new ${model}();
		${module}.setCode(rc.getCode());
		${module}.setRemark(rc.getRemark());
		return ${module};
	}

	@Transactional
	public Boolean destroy(${^module}UI ${module}) {
		${^module} rc = this.repository.findOne(${module}.getId());
		if (rc != null) {
			this.repository.delete(rc);
			return true;
		}
		return false;
	}

	@Transactional
	public ${^module}UI update(${^module}UI ${module}) {
		try {
			String errorCode = this.validateBeforeSave(${module});
			if (errorCode != null) {
				${^module} result = this.repository.findOne(${module}.getId());
				if (result != null) {
					BeanUtils.copyProperties(${module}, result);
					result.setLastUpdateUser(userService.getCurrentUserName());
					result.setLastUpdateDate(new Timestamp(new Date().getTime()));
					result = this.repository.saveAndFlush(result);
					BeanUtils.copyProperties(result, ${module});
				}
				return ${module};
			} else {
				${module}.setCode("Code has been existed");
				return ${module};
			}
		} catch (Exception e) {
			logger.error(e);
			throw new RuntimeException(e);
		}

	}

	public List<${^module}UI> find${^module}(ArrayList<FilterRequest> filters) {

		List<${^module}UI> rl = new ArrayList<${^module}UI>();

		Iterable<${^module}> l = this.repository.findAll(this.toPredicate(filters));
		${^module}UI vo = null;

		for (${^module} temp : l) {

			vo = new ${^module}UI();
			BeanUtils.copyProperties(temp, vo);

			rl.add(vo);
		}

		return rl;
	}

	private Predicate toPredicate(final List<FilterRequest> filters) {

		Q${^module} q${^module} = Q${^module}.${module};

		BooleanExpression result = null;

		try {
			for (FilterRequest filter : filters) {

				String column = filter.getProperty();
				BooleanExpression expression = null;
				if ("variableCode".equals(column)) {
					if (filter.getValue() != null) {
						expression = q${^module}.code.containsIgnoreCase("" + filter.getValue());
					}
				}

				if (expression != null) {
					if (result != null) {
						result = result.and(expression);
					} else {
						result = expression;
					}
				}
			}
		} catch (Exception ex) {
			logger.error("toPredicate:", ex);
		}

		return result;
	}

}
