package com.da.myapplication.domain.usecase

abstract class UseCase<Input, Output> {
    abstract suspend fun execute(input: Input): Output
}