package io.bordo.whatsgomobile.di

import io.bordo.common.data.repository.player.PlayerLocalDataSource
import io.bordo.common.data.repository.player.PlayerRemoteDataSource
import io.bordo.common.data.repository.player.PlayerRepositoryImp
import io.bordo.common.domain.repository.PlayerRepository
import io.bordo.common.domain.usecase.player.GetPlayerListUseCase
import io.bordo.whatsgomobile.ui.viewmodel.player.PlayerViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {

    singleOf(::GetPlayerListUseCase)

    singleOf(::PlayerRepositoryImp){ bind<PlayerRepository>() }
    singleOf(::PlayerRemoteDataSource)
    singleOf(::PlayerLocalDataSource)

    viewModelOf(::PlayerViewModel)

}