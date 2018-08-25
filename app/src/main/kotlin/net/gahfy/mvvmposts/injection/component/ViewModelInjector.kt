package net.gahfy.mvvmposts.injection.component

import dagger.Component
import net.gahfy.mvvmposts.injection.module.NetworkModule
import net.gahfy.mvvmposts.ui.post.PomodoroViewModel
import net.gahfy.mvvmposts.ui.post.PostListViewModel
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param postListViewModel PostListViewModel in which to inject the dependencies
     */
    fun inject(postListViewModel: PostListViewModel)
    fun inject(pomodoroViewModel: PomodoroViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}