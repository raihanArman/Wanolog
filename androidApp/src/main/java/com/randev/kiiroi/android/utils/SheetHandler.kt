package com.randev.kiiroi.android.utils

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.SwipeableDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

/**
 * @author Raihan Arman
 * @date 24/11/22
 */

data class SheetHandler @OptIn(ExperimentalMaterialApi::class) constructor(
    val initialValue: ModalBottomSheetValue,
    val skipHalfExpanded: Boolean,
    val confirmStateChange: (ModalBottomSheetValue) -> Boolean = { true }
){

    @OptIn(ExperimentalMaterialApi::class)
    fun state(block: suspend ModalBottomSheetState.()->Unit){
        stateScope.value = block
    }

    @OptIn(ExperimentalMaterialApi::class)
    private val stateScope = mutableStateOf<(suspend ModalBottomSheetState.()->Unit)?>(null)
    @OptIn(ExperimentalMaterialApi::class)
    private lateinit var _state: ModalBottomSheetState

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun handle(animationSpec: AnimationSpec<Float> = SwipeableDefaults.AnimationSpec): ModalBottomSheetState{
        _state = rememberSaveable(
            initialValue, animationSpec, skipHalfExpanded, confirmStateChange,
            saver = ModalBottomSheetState.Saver(
                animationSpec = animationSpec,
                skipHalfExpanded = skipHalfExpanded,
                confirmStateChange = confirmStateChange
            )
        ) {
            ModalBottomSheetState(
                initialValue = initialValue,
                animationSpec = animationSpec,
                isSkipHalfExpanded = skipHalfExpanded,
                confirmStateChange = confirmStateChange
            )
        }
        LaunchedEffect(key1 = stateScope.value){
            stateScope.value?.let {
                it(_state)
                stateScope.value = null
            }
        }
        return _state
    }
}