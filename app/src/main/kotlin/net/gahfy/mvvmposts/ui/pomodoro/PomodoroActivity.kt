package net.gahfy.mvvmposts.ui.post

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import net.gahfy.mvvmposts.R
import net.gahfy.mvvmposts.databinding.ActivityPomodoroBinding
import net.gahfy.mvvmposts.injection.ViewModelFactory

class PomodoroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPomodoroBinding
    private lateinit var viewModel: PomodoroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_pomodoro)
        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(PomodoroViewModel::class.java)
        binding.viewModel = viewModel
    }
}