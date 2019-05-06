package com.wcy.change.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserGoalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserGoalExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andGoalidIsNull() {
            addCriterion("goalID is null");
            return (Criteria) this;
        }

        public Criteria andGoalidIsNotNull() {
            addCriterion("goalID is not null");
            return (Criteria) this;
        }

        public Criteria andGoalidEqualTo(Integer value) {
            addCriterion("goalID =", value, "goalid");
            return (Criteria) this;
        }

        public Criteria andGoalidNotEqualTo(Integer value) {
            addCriterion("goalID <>", value, "goalid");
            return (Criteria) this;
        }

        public Criteria andGoalidGreaterThan(Integer value) {
            addCriterion("goalID >", value, "goalid");
            return (Criteria) this;
        }

        public Criteria andGoalidGreaterThanOrEqualTo(Integer value) {
            addCriterion("goalID >=", value, "goalid");
            return (Criteria) this;
        }

        public Criteria andGoalidLessThan(Integer value) {
            addCriterion("goalID <", value, "goalid");
            return (Criteria) this;
        }

        public Criteria andGoalidLessThanOrEqualTo(Integer value) {
            addCriterion("goalID <=", value, "goalid");
            return (Criteria) this;
        }

        public Criteria andGoalidIn(List<Integer> values) {
            addCriterion("goalID in", values, "goalid");
            return (Criteria) this;
        }

        public Criteria andGoalidNotIn(List<Integer> values) {
            addCriterion("goalID not in", values, "goalid");
            return (Criteria) this;
        }

        public Criteria andGoalidBetween(Integer value1, Integer value2) {
            addCriterion("goalID between", value1, value2, "goalid");
            return (Criteria) this;
        }

        public Criteria andGoalidNotBetween(Integer value1, Integer value2) {
            addCriterion("goalID not between", value1, value2, "goalid");
            return (Criteria) this;
        }

        public Criteria andClockinIsNull() {
            addCriterion("clockIn is null");
            return (Criteria) this;
        }

        public Criteria andClockinIsNotNull() {
            addCriterion("clockIn is not null");
            return (Criteria) this;
        }

        public Criteria andClockinEqualTo(Integer value) {
            addCriterion("clockIn =", value, "clockin");
            return (Criteria) this;
        }

        public Criteria andClockinNotEqualTo(Integer value) {
            addCriterion("clockIn <>", value, "clockin");
            return (Criteria) this;
        }

        public Criteria andClockinGreaterThan(Integer value) {
            addCriterion("clockIn >", value, "clockin");
            return (Criteria) this;
        }

        public Criteria andClockinGreaterThanOrEqualTo(Integer value) {
            addCriterion("clockIn >=", value, "clockin");
            return (Criteria) this;
        }

        public Criteria andClockinLessThan(Integer value) {
            addCriterion("clockIn <", value, "clockin");
            return (Criteria) this;
        }

        public Criteria andClockinLessThanOrEqualTo(Integer value) {
            addCriterion("clockIn <=", value, "clockin");
            return (Criteria) this;
        }

        public Criteria andClockinIn(List<Integer> values) {
            addCriterion("clockIn in", values, "clockin");
            return (Criteria) this;
        }

        public Criteria andClockinNotIn(List<Integer> values) {
            addCriterion("clockIn not in", values, "clockin");
            return (Criteria) this;
        }

        public Criteria andClockinBetween(Integer value1, Integer value2) {
            addCriterion("clockIn between", value1, value2, "clockin");
            return (Criteria) this;
        }

        public Criteria andClockinNotBetween(Integer value1, Integer value2) {
            addCriterion("clockIn not between", value1, value2, "clockin");
            return (Criteria) this;
        }

        public Criteria andMissIsNull() {
            addCriterion("miss is null");
            return (Criteria) this;
        }

        public Criteria andMissIsNotNull() {
            addCriterion("miss is not null");
            return (Criteria) this;
        }

        public Criteria andMissEqualTo(Integer value) {
            addCriterion("miss =", value, "miss");
            return (Criteria) this;
        }

        public Criteria andMissNotEqualTo(Integer value) {
            addCriterion("miss <>", value, "miss");
            return (Criteria) this;
        }

        public Criteria andMissGreaterThan(Integer value) {
            addCriterion("miss >", value, "miss");
            return (Criteria) this;
        }

        public Criteria andMissGreaterThanOrEqualTo(Integer value) {
            addCriterion("miss >=", value, "miss");
            return (Criteria) this;
        }

        public Criteria andMissLessThan(Integer value) {
            addCriterion("miss <", value, "miss");
            return (Criteria) this;
        }

        public Criteria andMissLessThanOrEqualTo(Integer value) {
            addCriterion("miss <=", value, "miss");
            return (Criteria) this;
        }

        public Criteria andMissIn(List<Integer> values) {
            addCriterion("miss in", values, "miss");
            return (Criteria) this;
        }

        public Criteria andMissNotIn(List<Integer> values) {
            addCriterion("miss not in", values, "miss");
            return (Criteria) this;
        }

        public Criteria andMissBetween(Integer value1, Integer value2) {
            addCriterion("miss between", value1, value2, "miss");
            return (Criteria) this;
        }

        public Criteria andMissNotBetween(Integer value1, Integer value2) {
            addCriterion("miss not between", value1, value2, "miss");
            return (Criteria) this;
        }

        public Criteria andContinuationIsNull() {
            addCriterion("continuation is null");
            return (Criteria) this;
        }

        public Criteria andContinuationIsNotNull() {
            addCriterion("continuation is not null");
            return (Criteria) this;
        }

        public Criteria andContinuationEqualTo(Integer value) {
            addCriterion("continuation =", value, "continuation");
            return (Criteria) this;
        }

        public Criteria andContinuationNotEqualTo(Integer value) {
            addCriterion("continuation <>", value, "continuation");
            return (Criteria) this;
        }

        public Criteria andContinuationGreaterThan(Integer value) {
            addCriterion("continuation >", value, "continuation");
            return (Criteria) this;
        }

        public Criteria andContinuationGreaterThanOrEqualTo(Integer value) {
            addCriterion("continuation >=", value, "continuation");
            return (Criteria) this;
        }

        public Criteria andContinuationLessThan(Integer value) {
            addCriterion("continuation <", value, "continuation");
            return (Criteria) this;
        }

        public Criteria andContinuationLessThanOrEqualTo(Integer value) {
            addCriterion("continuation <=", value, "continuation");
            return (Criteria) this;
        }

        public Criteria andContinuationIn(List<Integer> values) {
            addCriterion("continuation in", values, "continuation");
            return (Criteria) this;
        }

        public Criteria andContinuationNotIn(List<Integer> values) {
            addCriterion("continuation not in", values, "continuation");
            return (Criteria) this;
        }

        public Criteria andContinuationBetween(Integer value1, Integer value2) {
            addCriterion("continuation between", value1, value2, "continuation");
            return (Criteria) this;
        }

        public Criteria andContinuationNotBetween(Integer value1, Integer value2) {
            addCriterion("continuation not between", value1, value2, "continuation");
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
    }
}