package com.example.jetpackcompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

class ComposableFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent() {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)) {

                    }

                }
            }
        }
    }
}