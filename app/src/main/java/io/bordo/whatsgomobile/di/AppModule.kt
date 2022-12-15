package io.bordo.whatsgomobile.di

import io.bordo.common.data.repository.player.PlayerLocalDataSource
import io.bordo.common.data.repository.player.PlayerRemoteDataSource
import io.bordo.common.data.repository.player.PlayerRepositoryImp
import io.bordo.common.domain.repository.PlayerRepository
import io.bordo.common.domain.usercase.player.GetPlayerListUseCase
import io.bordo.whatsgomobile.ui.viewmodel.player.PlayerViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    single { GetPlayerListUseCase(get()) }

    factory<PlayerRepository> {
        PlayerRepositoryImp(get())
    }

    factory { PlayerRemoteDataSource(get()) }

    factory { PlayerLocalDataSource() }

    viewModelOf(::PlayerViewModel)

}