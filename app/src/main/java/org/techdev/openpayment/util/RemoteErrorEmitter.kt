package org.techdev.openpayment.util

/**
 * PRO: Notify the errors to the classes
 */
interface RemoteErrorEmitter {
    fun onError(msg: String)
    fun onError(errorType: ErrorType)
}