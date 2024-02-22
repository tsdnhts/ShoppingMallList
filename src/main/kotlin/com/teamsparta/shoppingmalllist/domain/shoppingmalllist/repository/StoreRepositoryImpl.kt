package com.teamsparta.shoppingmalllist.domain.shoppingmalllist.repository

import com.querydsl.core.BooleanBuilder
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.QStore
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.Store
import com.teamsparta.shoppingmalllist.domain.shoppingmalllist.model.StoreState
import com.teamsparta.shoppingmalllist.global.config.QueryDslSupport
import org.springframework.stereotype.Repository

// QueryDSL를 작성하는 Repository (고차원적이고 더 구체적인 query를 작성하기 위해)

@Repository
class StoreRepositoryImpl : QueryDslSupport(), CustomStoreRepository {
    // Q 클래스 선언
    private val store = QStore.store

    override fun searchStores(score: Int?, state: StoreState?): List<Store> {
        // 조건문 설정
        val whereClause = BooleanBuilder()
        score?.let { whereClause.and(store.score.goe(score))}
        state?.let {
            whereClause.and(store.state.eq(it))
        } // state 가 null 이 아닌 경우(= state 에 체크가 된 경우) 조건 추가

        // 조건문을 대입한 목록 조회
        // SELECT * from store where ...
        // 이런 쿼리들을 문자열로 사용하는 것이 아니라, 좀더 객체지향적으로 사용하기 위해 (=메서드 체인)
        val storeList = queryFactory.selectFrom(store).where(whereClause).fetch()
        return storeList
    }
}