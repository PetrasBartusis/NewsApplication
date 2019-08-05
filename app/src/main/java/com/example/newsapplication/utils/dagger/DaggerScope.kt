package com.example.newsapplication.utils.dagger

import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
annotation class DaggerScope(val klass: KClass<*>)