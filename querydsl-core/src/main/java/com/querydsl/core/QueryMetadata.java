/*
 * Copyright 2011, Mysema Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.querydsl.core;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.ParamExpression;
import com.querydsl.core.types.Predicate;

/**
 * {@code QueryMetadata} defines query metadata such as query sources, filtering
 * conditions and the projection
 *
 * @author tiwe
 */
public interface QueryMetadata extends Serializable {

    /**
     * Add the given group by expressions
     *
     * @param o group by expressions
     */
    void addGroupBy(Expression<?> o);

    /**
     * Add the given having expressions
     *
     * @param o having conditions
     */
    void addHaving(Predicate o);

    /**
     * Add the given query join
     *
     * @param joinType type of join
     * @param expr join target
     */
    void addJoin(JoinType joinType, Expression<?> expr);

    /**
     * Add the given join flag to the last given join
     *
     * @param flag join flag
     */
    void addJoinFlag(JoinFlag flag);

    /**
     * Add the given join condition to the last given join
     *
     * @param o join condition
     */
    void addJoinCondition(Predicate o);

    /**
     * Add the given order specifiers
     *
     * @param o order
     */
    void addOrderBy(OrderSpecifier<?> o);

    /**
     * Add the given where expressions
     *
     * @param o where condition
     */
    void addWhere(Predicate o);

    /**
     * Clear the order expressions
     */
    void clearOrderBy();

    /**
     * Clear the where expressions
     */
    void clearWhere();

    /**
     * Clone this QueryMetadata instance
     *
     * @return new QueryMetadata instance with cloned state
     */
    QueryMetadata clone();

    /**
     * Get the group by expressions
     *
     * @return
     */
    List<Expression<?>> getGroupBy();

    /**
     * Get the having expressions
     *
     * @return
     */
    @Nullable
    Predicate getHaving();

    /**
     * Get the query joins
     *
     * @return
     */
    List<JoinExpression> getJoins();

    /**
     * Get the QueryModifiers
     *
     * @return
     */
    QueryModifiers getModifiers();

    /**
     * Get the OrderSpecifiers
     *
     * @return
     */
    List<OrderSpecifier<?>> getOrderBy();

    /**
     * Get the projection
     *
     * @return
     */
    @Nullable
    Expression<?> getProjection();

    /**
     * Get the parameters
     *
     * @return
     */
    Map<ParamExpression<?>,Object> getParams();

    /**
     * Get the expressions aggregated into a single boolean expression or null,
     * if none where defined
     *
     * @return
     */
    @Nullable
    Predicate getWhere();

    /**
     * Get whether the projection is distinct
     *
     * @return
     */
    boolean isDistinct();

    /**
     * Get whether the projection is unique
     *
     * @return
     */
    boolean isUnique();

    /**
     * Reset the projection
     */
    void reset();

    /**
     * Set the distinct flag
     *
     * @param distinct
     */
    void setDistinct(boolean distinct);

    /**
     * Set the maxmium amount of rows
     *
     * @param limit
     */
    void setLimit(@Nullable Long limit);

    /**
     * Set the query modifiers limit and offset
     *
     * @param restriction
     */
    void setModifiers(QueryModifiers restriction);

    /**
     * Set the amount of skipped rows
     *
     * @param offset
     */
    void setOffset(@Nullable Long offset);

    /**
     * @param unique
     */
    void setUnique(boolean unique);

    /**
     * Bind the value for the given parameter expression
     *
     * @param <T>
     * @param param
     * @param value
     */
    <T> void setParam(ParamExpression<T> param, T value);

    /**
     * Set the projection
     *
     * @param o
     */
    void setProjection(Expression<?> o);

    /**
     * Add the given query flag
     *
     * @param flag
     */
    void addFlag(QueryFlag flag);

    /**
     * Return whether the given query flag is applied
     *
     * @param flag
     * @return
     */
    boolean hasFlag(QueryFlag flag);

    /**
     * Remove the given query flag
     *
     * @param flag
     */
    void removeFlag(QueryFlag flag);

    /**
     * Get all query flags
     *
     * @return
     */
    Set<QueryFlag> getFlags();

    /**
     * Set the validate flag
     *
     * @param v
     */
    void setValidate(boolean v);
}
