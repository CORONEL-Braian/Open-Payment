package org.techdev.openpayment.extensions

import android.app.Activity
import org.techdev.openpayment.OpenPaymentApp

val Activity.app: OpenPaymentApp
    get() = application as OpenPaymentApp