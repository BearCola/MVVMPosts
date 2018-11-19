package net.gahfy.mvvmposts.ui.pomodoro

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import net.gahfy.mvvmposts.R
import net.gahfy.mvvmposts.databinding.ActivityPomodoroBinding
import net.gahfy.mvvmposts.injection.ViewModelFactory
import net.gahfy.mvvmposts.ui.post.PomodoroViewModel

class PomodoroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPomodoroBinding
    private lateinit var viewModel: PomodoroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeStatusBarColor()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_pomodoro)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(PomodoroViewModel::class.java)
        binding.viewModel = viewModel
    }

    private fun changeStatusBarColor() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.naverColor)
    }
}