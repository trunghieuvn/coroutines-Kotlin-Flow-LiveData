package com.example.ckfl.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract  class BaseActivity<VM: ViewModel, VB : ViewBinding> : AppCompatActivity() {

}