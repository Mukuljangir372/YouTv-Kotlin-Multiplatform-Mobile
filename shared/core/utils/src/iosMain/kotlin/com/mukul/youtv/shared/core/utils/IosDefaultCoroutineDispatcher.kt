package com.mukul.youtv.shared.core.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.Foundation.NSRunLoop
import platform.Foundation.performBlock
import kotlin.coroutines.CoroutineContext

// In iOS, Run loop allow threads to process events in realtime.
// Here, By using NsRunLoop, we're allowing the main run loop to
// process the event/block in realtime.
class IosDefaultCoroutineDispatcher: CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        NSRunLoop.mainRunLoop.performBlock {
            block.run()
        }
    }
}