package com.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CommentExample {

	/**
	 * 排序从句
	 */
	protected String orderByClause;

	/**
	 * 是否使用distinct查询（去重查询）
	 */
	protected boolean distinct;

	/**
	 * example中包含多个criteria，
	 * criteria包含多个Criterion条件，条件中的内容是以and的形式加到where上的，
	 * criteria与criteria之间是以or的形式添加到where中的。
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * 构造方法，初始化criteria条件列表。
	 */
	public CommentExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
 		return oredCriteria;
	}

	/**
	 * or形式在条件语句criteria列表中拼接一个新的criteria。
	 * @param criteria [Criteria]自定义的条件
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * or形式在条件语句criteria列表中创建一个新的criteria，并返回。
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 创建一个条件语句criteria，
	 * 如果criteria列表中没有元素，则返回根节点。
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * 创建一个条件语句criteria（内部方法）。
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 清空criteria列表中。
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	 /**
	 * 每个crteria中都有一个criterion列表，子条件列表，用and语句相互连接。
	 */
	public static class Criterion {

		 /**
		 * 条件关键字，例如：>=、<=等等
		 */
		private String condition;

		/**
		 * 条件语句会用到的值1
		 */
		private Object value;

		/**
		 * 条件语句会用到的值2
		 */
		private Object secondValue;

		/**
		 * 条件关键字没有值，例如：not null、 null
		 */
		private boolean noValue;

		/**
		 * 条件关键字有且只有一个值，例如：>= 1、<= 1
		 */
		private boolean singleValue;

		/**
		 * 条件关键字有且只有两个值，例如：between 1 and 2
		 */
		private boolean betweenValue;

		/**
		 * 条件关键字有且只有一个列表的值，例如：in(1、2、3、4)
		 */
		private boolean listValue;

		/**
		 * 该条件针对的字段名
		 */
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		/**
		 * 无参数条件构造方法
		 * @param condition [String]条件关键字
		 */
		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		/**
		 * 单值参数或列表参数构造方法
		 * @param condition [String]条件关键字
		 * @param value [Object]条件语句会用到的值1
		 * @param typeHandler [String]该条件针对的字段名
		 */
		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		/**
		 * 单值参数或列表参数构造方法（不指定所属字段）
		 * @param condition [String]条件关键字
		 * @param value [Object]条件语句会用到的值1
		 */
		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		/**
		 * 双参数构造方法
		 * @param condition [String]条件关键字
		 * @param value [Object]条件语句会用到的值1
		 * @param secondValue [Object]条件语句会用到的值2
		 * @param typeHandler [String]该条件针对的字段名
		 */
		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		/**
		 * 双参数构造方法（不指定所属字段）
		 * @param condition [String]条件关键字
		 * @param value [Object]条件语句会用到的值1
		 * @param secondValue [Object]条件语句会用到的值2
		 */
		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
	 * criteria条件类，父类GeneratedCriteria是动态生成的。
	 */
	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	/**
	 * 动态生成的Criteria父类
	 */
	protected abstract static class GeneratedCriteria {

		/**
		 * 条件列表集合
		 */
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		/**
		 * 条件列表集合中是否有值
		 * @return [boolean]true : 有、 false : 没有
		 */
		public boolean isValid() {
			return criteria.size() > 0;
		}

		/**
		 * 获取条件列表集合
		 * @return [List<Criterion>]条件列表集合
		 */
		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		/**
		 * 获取条件列表集合
		 * @return [List<Criterion>]条件列表集合
		 */
		public List<Criterion> getCriteria() {
			return criteria;
		}

		/**
		 * 无参数添加条件
 		 * @param condition [String]条件语句
		 * @exception [RuntimeException]输入条件语句不能为null
		 */
		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		/**
		 * 单参数添加条件
 		 * @param condition [String]条件语句
 		 * @param value [Object]条件语句会用到的值1
 		 * @param property [String]该条件针对的属性名
		 * @exception [RuntimeException]输入条件语句不能为null
		 */
		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		/**
		 * 双参数添加条件
 		 * @param condition [String]条件语句
 		 * @param value1 [Object]条件语句会用到的值1
 		 * @param value2 [Object]条件语句会用到的值2
 		 * @param property [String]该条件针对的属性名
		 * @exception [RuntimeException]输入条件语句不能为null
		 */
		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}
		
		/**
		 * c_id字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCIdIsNull() {
			addCriterion("c_id is null");
			return (Criteria) this;
		}

		/**
		 * c_id字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCIdIsNotNull() {
			addCriterion("c_id is not null");
			return (Criteria) this;
		}

		/**
		 * c_id等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCIdEqualTo(Integer value) {
			addCriterion("c_id =", value, "cId");
			return (Criteria) this;
		}

		/**
		 * c_id不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCIdNotEqualTo(Integer value) {
			addCriterion("c_id <>", value, "cId");
			return (Criteria) this;
		}

		/**
		 * c_id大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCIdGreaterThan(Integer value) {
			addCriterion("c_id >", value, "cId");
			return (Criteria) this;
		}

		/**
		 * c_id大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("c_id >=", value, "cId");
			return (Criteria) this;
		}

		/**
		 * c_id小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCIdLessThan(Integer value) {
			addCriterion("c_id <", value, "cId");
			return (Criteria) this;
		}

		/**
		 * c_id小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCIdLessThanOrEqualTo(Integer value) {
			addCriterion("c_id <=", value, "cId");
			return (Criteria) this;
		}

		/**
		 * c_id在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCIdIn(List<Integer> values) {
			addCriterion("c_id in", values, "cId");
			return (Criteria) this;
		}

		/**
		 * c_id不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCIdNotIn(List<Integer> values) {
			addCriterion("c_id not in", values, "cId");
			return (Criteria) this;
		}

		/**
		 * c_id在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCIdBetween(Integer value1, Integer value2) {
			addCriterion("c_id between", value1, value2, "cId");
			return (Criteria) this;
		}

		/**
		 * c_id不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCIdNotBetween(Integer value1, Integer value2) {
			addCriterion("c_id not between", value1, value2, "cId");
			return (Criteria) this;
		}
		/**
		 * c_content字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCContentIsNull() {
			addCriterion("c_content is null");
			return (Criteria) this;
		}

		/**
		 * c_content字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCContentIsNotNull() {
			addCriterion("c_content is not null");
			return (Criteria) this;
		}

		/**
		 * c_content等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCContentEqualTo(String value) {
			addCriterion("c_content =", value, "cContent");
			return (Criteria) this;
		}

		/**
		 * c_content不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCContentNotEqualTo(String value) {
			addCriterion("c_content <>", value, "cContent");
			return (Criteria) this;
		}

		/**
		 * c_content大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCContentGreaterThan(String value) {
			addCriterion("c_content >", value, "cContent");
			return (Criteria) this;
		}

		/**
		 * c_content大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCContentGreaterThanOrEqualTo(String value) {
			addCriterion("c_content >=", value, "cContent");
			return (Criteria) this;
		}

		/**
		 * c_content小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCContentLessThan(String value) {
			addCriterion("c_content <", value, "cContent");
			return (Criteria) this;
		}

		/**
		 * c_content小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCContentLessThanOrEqualTo(String value) {
			addCriterion("c_content <=", value, "cContent");
			return (Criteria) this;
		}

		/**
		 * c_content在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCContentIn(List<String> values) {
			addCriterion("c_content in", values, "cContent");
			return (Criteria) this;
		}

		/**
		 * c_content不在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCContentNotIn(List<String> values) {
			addCriterion("c_content not in", values, "cContent");
			return (Criteria) this;
		}

		/**
		 * c_content在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCContentBetween(String value1, String value2) {
			addCriterion("c_content between", value1, value2, "cContent");
			return (Criteria) this;
		}

		/**
		 * c_content不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCContentNotBetween(String value1, String value2) {
			addCriterion("c_content not between", value1, value2, "cContent");
			return (Criteria) this;
		}
		/**
		 * u_id字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdIsNull() {
			addCriterion("u_id is null");
			return (Criteria) this;
		}

		/**
		 * u_id字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdIsNotNull() {
			addCriterion("u_id is not null");
			return (Criteria) this;
		}

		/**
		 * u_id等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdEqualTo(Integer value) {
			addCriterion("u_id =", value, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdNotEqualTo(Integer value) {
			addCriterion("u_id <>", value, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdGreaterThan(Integer value) {
			addCriterion("u_id >", value, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("u_id >=", value, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdLessThan(Integer value) {
			addCriterion("u_id <", value, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdLessThanOrEqualTo(Integer value) {
			addCriterion("u_id <=", value, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdIn(List<Integer> values) {
			addCriterion("u_id in", values, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdNotIn(List<Integer> values) {
			addCriterion("u_id not in", values, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdBetween(Integer value1, Integer value2) {
			addCriterion("u_id between", value1, value2, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdNotBetween(Integer value1, Integer value2) {
			addCriterion("u_id not between", value1, value2, "uId");
			return (Criteria) this;
		}
		/**
		 * task_id字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdIsNull() {
			addCriterion("task_id is null");
			return (Criteria) this;
		}

		/**
		 * task_id字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdIsNotNull() {
			addCriterion("task_id is not null");
			return (Criteria) this;
		}

		/**
		 * task_id等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdEqualTo(Integer value) {
			addCriterion("task_id =", value, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdNotEqualTo(Integer value) {
			addCriterion("task_id <>", value, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdGreaterThan(Integer value) {
			addCriterion("task_id >", value, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("task_id >=", value, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdLessThan(Integer value) {
			addCriterion("task_id <", value, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
			addCriterion("task_id <=", value, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdIn(List<Integer> values) {
			addCriterion("task_id in", values, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdNotIn(List<Integer> values) {
			addCriterion("task_id not in", values, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdBetween(Integer value1, Integer value2) {
			addCriterion("task_id between", value1, value2, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
			addCriterion("task_id not between", value1, value2, "taskId");
			return (Criteria) this;
		}
		/**
		 * c_time字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCTimeIsNull() {
			addCriterion("c_time is null");
			return (Criteria) this;
		}

		/**
		 * c_time字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCTimeIsNotNull() {
			addCriterion("c_time is not null");
			return (Criteria) this;
		}

		/**
		 * c_time等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCTimeEqualTo(Timestamp value) {
			addCriterion("c_time =", value, "cTime");
			return (Criteria) this;
		}

		/**
		 * c_time不等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCTimeNotEqualTo(Timestamp value) {
			addCriterion("c_time <>", value, "cTime");
			return (Criteria) this;
		}

		/**
		 * c_time大于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCTimeGreaterThan(Timestamp value) {
			addCriterion("c_time >", value, "cTime");
			return (Criteria) this;
		}

		/**
		 * c_time大于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCTimeGreaterThanOrEqualTo(Timestamp value) {
			addCriterion("c_time >=", value, "cTime");
			return (Criteria) this;
		}

		/**
		 * c_time小于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCTimeLessThan(Timestamp value) {
			addCriterion("c_time <", value, "cTime");
			return (Criteria) this;
		}

		/**
		 * c_time小于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCTimeLessThanOrEqualTo(Timestamp value) {
			addCriterion("c_time <=", value, "cTime");
			return (Criteria) this;
		}

		/**
		 * c_time在传入值之中
		 * @param values [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCTimeIn(List<Timestamp> values) {
			addCriterion("c_time in", values, "cTime");
			return (Criteria) this;
		}

		/**
		 * c_time不在传入值之中
		 * @param values [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCTimeNotIn(List<Timestamp> values) {
			addCriterion("c_time not in", values, "cTime");
			return (Criteria) this;
		}

		/**
		 * c_time在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCTimeBetween(Timestamp value1, Timestamp value2) {
			addCriterion("c_time between", value1, value2, "cTime");
			return (Criteria) this;
		}

		/**
		 * c_time不在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andCTimeNotBetween(Timestamp value1, Timestamp value2) {
			addCriterion("c_time not between", value1, value2, "cTime");
			return (Criteria) this;
		}

	}
}