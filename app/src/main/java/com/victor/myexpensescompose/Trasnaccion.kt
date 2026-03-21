package com.victor.myexpensescompose

import java.sql.Date

data class Trasnaccion(
    var name : String,
    var amount : Double,
    var date : Date,
    var category : Category,
    var tags : Tags,
    var notes : String? = null

)
