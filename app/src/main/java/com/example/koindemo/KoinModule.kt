package com.example.koindemo

import org.koin.core.qualifier.named
import org.koin.dsl.module

val firstModule = module {

    single<Any>(named("singletone")) { object {} }
    factory<Any>(named("factory")) { object {} }
}

val scopeModule = module {

    scope<SecondActivity> {
        scoped(named("scopedObj")) { object {} }
        factory<Any>(named("scoped_factory")) { object {} }
    }
}