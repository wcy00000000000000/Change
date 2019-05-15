package com.wcy.change.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserWeeklyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserWeeklyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMonIsNull() {
            addCriterion("mon is null");
            return (Criteria) this;
        }

        public Criteria andMonIsNotNull() {
            addCriterion("mon is not null");
            return (Criteria) this;
        }

        public Criteria andMonEqualTo(Integer value) {
            addCriterion("mon =", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonNotEqualTo(Integer value) {
            addCriterion("mon <>", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonGreaterThan(Integer value) {
            addCriterion("mon >", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonGreaterThanOrEqualTo(Integer value) {
            addCriterion("mon >=", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonLessThan(Integer value) {
            addCriterion("mon <", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonLessThanOrEqualTo(Integer value) {
            addCriterion("mon <=", value, "mon");
            return (Criteria) this;
        }

        public Criteria andMonIn(List<Integer> values) {
            addCriterion("mon in", values, "mon");
            return (Criteria) this;
        }

        public Criteria andMonNotIn(List<Integer> values) {
            addCriterion("mon not in", values, "mon");
            return (Criteria) this;
        }

        public Criteria andMonBetween(Integer value1, Integer value2) {
            addCriterion("mon between", value1, value2, "mon");
            return (Criteria) this;
        }

        public Criteria andMonNotBetween(Integer value1, Integer value2) {
            addCriterion("mon not between", value1, value2, "mon");
            return (Criteria) this;
        }

        public Criteria andTueIsNull() {
            addCriterion("tue is null");
            return (Criteria) this;
        }

        public Criteria andTueIsNotNull() {
            addCriterion("tue is not null");
            return (Criteria) this;
        }

        public Criteria andTueEqualTo(Integer value) {
            addCriterion("tue =", value, "tue");
            return (Criteria) this;
        }

        public Criteria andTueNotEqualTo(Integer value) {
            addCriterion("tue <>", value, "tue");
            return (Criteria) this;
        }

        public Criteria andTueGreaterThan(Integer value) {
            addCriterion("tue >", value, "tue");
            return (Criteria) this;
        }

        public Criteria andTueGreaterThanOrEqualTo(Integer value) {
            addCriterion("tue >=", value, "tue");
            return (Criteria) this;
        }

        public Criteria andTueLessThan(Integer value) {
            addCriterion("tue <", value, "tue");
            return (Criteria) this;
        }

        public Criteria andTueLessThanOrEqualTo(Integer value) {
            addCriterion("tue <=", value, "tue");
            return (Criteria) this;
        }

        public Criteria andTueIn(List<Integer> values) {
            addCriterion("tue in", values, "tue");
            return (Criteria) this;
        }

        public Criteria andTueNotIn(List<Integer> values) {
            addCriterion("tue not in", values, "tue");
            return (Criteria) this;
        }

        public Criteria andTueBetween(Integer value1, Integer value2) {
            addCriterion("tue between", value1, value2, "tue");
            return (Criteria) this;
        }

        public Criteria andTueNotBetween(Integer value1, Integer value2) {
            addCriterion("tue not between", value1, value2, "tue");
            return (Criteria) this;
        }

        public Criteria andWedIsNull() {
            addCriterion("wed is null");
            return (Criteria) this;
        }

        public Criteria andWedIsNotNull() {
            addCriterion("wed is not null");
            return (Criteria) this;
        }

        public Criteria andWedEqualTo(Integer value) {
            addCriterion("wed =", value, "wed");
            return (Criteria) this;
        }

        public Criteria andWedNotEqualTo(Integer value) {
            addCriterion("wed <>", value, "wed");
            return (Criteria) this;
        }

        public Criteria andWedGreaterThan(Integer value) {
            addCriterion("wed >", value, "wed");
            return (Criteria) this;
        }

        public Criteria andWedGreaterThanOrEqualTo(Integer value) {
            addCriterion("wed >=", value, "wed");
            return (Criteria) this;
        }

        public Criteria andWedLessThan(Integer value) {
            addCriterion("wed <", value, "wed");
            return (Criteria) this;
        }

        public Criteria andWedLessThanOrEqualTo(Integer value) {
            addCriterion("wed <=", value, "wed");
            return (Criteria) this;
        }

        public Criteria andWedIn(List<Integer> values) {
            addCriterion("wed in", values, "wed");
            return (Criteria) this;
        }

        public Criteria andWedNotIn(List<Integer> values) {
            addCriterion("wed not in", values, "wed");
            return (Criteria) this;
        }

        public Criteria andWedBetween(Integer value1, Integer value2) {
            addCriterion("wed between", value1, value2, "wed");
            return (Criteria) this;
        }

        public Criteria andWedNotBetween(Integer value1, Integer value2) {
            addCriterion("wed not between", value1, value2, "wed");
            return (Criteria) this;
        }

        public Criteria andThurIsNull() {
            addCriterion("thur is null");
            return (Criteria) this;
        }

        public Criteria andThurIsNotNull() {
            addCriterion("thur is not null");
            return (Criteria) this;
        }

        public Criteria andThurEqualTo(Integer value) {
            addCriterion("thur =", value, "thur");
            return (Criteria) this;
        }

        public Criteria andThurNotEqualTo(Integer value) {
            addCriterion("thur <>", value, "thur");
            return (Criteria) this;
        }

        public Criteria andThurGreaterThan(Integer value) {
            addCriterion("thur >", value, "thur");
            return (Criteria) this;
        }

        public Criteria andThurGreaterThanOrEqualTo(Integer value) {
            addCriterion("thur >=", value, "thur");
            return (Criteria) this;
        }

        public Criteria andThurLessThan(Integer value) {
            addCriterion("thur <", value, "thur");
            return (Criteria) this;
        }

        public Criteria andThurLessThanOrEqualTo(Integer value) {
            addCriterion("thur <=", value, "thur");
            return (Criteria) this;
        }

        public Criteria andThurIn(List<Integer> values) {
            addCriterion("thur in", values, "thur");
            return (Criteria) this;
        }

        public Criteria andThurNotIn(List<Integer> values) {
            addCriterion("thur not in", values, "thur");
            return (Criteria) this;
        }

        public Criteria andThurBetween(Integer value1, Integer value2) {
            addCriterion("thur between", value1, value2, "thur");
            return (Criteria) this;
        }

        public Criteria andThurNotBetween(Integer value1, Integer value2) {
            addCriterion("thur not between", value1, value2, "thur");
            return (Criteria) this;
        }

        public Criteria andFriIsNull() {
            addCriterion("fri is null");
            return (Criteria) this;
        }

        public Criteria andFriIsNotNull() {
            addCriterion("fri is not null");
            return (Criteria) this;
        }

        public Criteria andFriEqualTo(Integer value) {
            addCriterion("fri =", value, "fri");
            return (Criteria) this;
        }

        public Criteria andFriNotEqualTo(Integer value) {
            addCriterion("fri <>", value, "fri");
            return (Criteria) this;
        }

        public Criteria andFriGreaterThan(Integer value) {
            addCriterion("fri >", value, "fri");
            return (Criteria) this;
        }

        public Criteria andFriGreaterThanOrEqualTo(Integer value) {
            addCriterion("fri >=", value, "fri");
            return (Criteria) this;
        }

        public Criteria andFriLessThan(Integer value) {
            addCriterion("fri <", value, "fri");
            return (Criteria) this;
        }

        public Criteria andFriLessThanOrEqualTo(Integer value) {
            addCriterion("fri <=", value, "fri");
            return (Criteria) this;
        }

        public Criteria andFriIn(List<Integer> values) {
            addCriterion("fri in", values, "fri");
            return (Criteria) this;
        }

        public Criteria andFriNotIn(List<Integer> values) {
            addCriterion("fri not in", values, "fri");
            return (Criteria) this;
        }

        public Criteria andFriBetween(Integer value1, Integer value2) {
            addCriterion("fri between", value1, value2, "fri");
            return (Criteria) this;
        }

        public Criteria andFriNotBetween(Integer value1, Integer value2) {
            addCriterion("fri not between", value1, value2, "fri");
            return (Criteria) this;
        }

        public Criteria andSatIsNull() {
            addCriterion("sat is null");
            return (Criteria) this;
        }

        public Criteria andSatIsNotNull() {
            addCriterion("sat is not null");
            return (Criteria) this;
        }

        public Criteria andSatEqualTo(Integer value) {
            addCriterion("sat =", value, "sat");
            return (Criteria) this;
        }

        public Criteria andSatNotEqualTo(Integer value) {
            addCriterion("sat <>", value, "sat");
            return (Criteria) this;
        }

        public Criteria andSatGreaterThan(Integer value) {
            addCriterion("sat >", value, "sat");
            return (Criteria) this;
        }

        public Criteria andSatGreaterThanOrEqualTo(Integer value) {
            addCriterion("sat >=", value, "sat");
            return (Criteria) this;
        }

        public Criteria andSatLessThan(Integer value) {
            addCriterion("sat <", value, "sat");
            return (Criteria) this;
        }

        public Criteria andSatLessThanOrEqualTo(Integer value) {
            addCriterion("sat <=", value, "sat");
            return (Criteria) this;
        }

        public Criteria andSatIn(List<Integer> values) {
            addCriterion("sat in", values, "sat");
            return (Criteria) this;
        }

        public Criteria andSatNotIn(List<Integer> values) {
            addCriterion("sat not in", values, "sat");
            return (Criteria) this;
        }

        public Criteria andSatBetween(Integer value1, Integer value2) {
            addCriterion("sat between", value1, value2, "sat");
            return (Criteria) this;
        }

        public Criteria andSatNotBetween(Integer value1, Integer value2) {
            addCriterion("sat not between", value1, value2, "sat");
            return (Criteria) this;
        }

        public Criteria andSunIsNull() {
            addCriterion("sun is null");
            return (Criteria) this;
        }

        public Criteria andSunIsNotNull() {
            addCriterion("sun is not null");
            return (Criteria) this;
        }

        public Criteria andSunEqualTo(Integer value) {
            addCriterion("sun =", value, "sun");
            return (Criteria) this;
        }

        public Criteria andSunNotEqualTo(Integer value) {
            addCriterion("sun <>", value, "sun");
            return (Criteria) this;
        }

        public Criteria andSunGreaterThan(Integer value) {
            addCriterion("sun >", value, "sun");
            return (Criteria) this;
        }

        public Criteria andSunGreaterThanOrEqualTo(Integer value) {
            addCriterion("sun >=", value, "sun");
            return (Criteria) this;
        }

        public Criteria andSunLessThan(Integer value) {
            addCriterion("sun <", value, "sun");
            return (Criteria) this;
        }

        public Criteria andSunLessThanOrEqualTo(Integer value) {
            addCriterion("sun <=", value, "sun");
            return (Criteria) this;
        }

        public Criteria andSunIn(List<Integer> values) {
            addCriterion("sun in", values, "sun");
            return (Criteria) this;
        }

        public Criteria andSunNotIn(List<Integer> values) {
            addCriterion("sun not in", values, "sun");
            return (Criteria) this;
        }

        public Criteria andSunBetween(Integer value1, Integer value2) {
            addCriterion("sun between", value1, value2, "sun");
            return (Criteria) this;
        }

        public Criteria andSunNotBetween(Integer value1, Integer value2) {
            addCriterion("sun not between", value1, value2, "sun");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

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

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }

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
    }
}