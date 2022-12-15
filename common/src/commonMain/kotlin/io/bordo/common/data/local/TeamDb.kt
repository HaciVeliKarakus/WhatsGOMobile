package io.bordo.common.data.local

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class TeamDb : RealmObject {
    @PrimaryKey
    var id: Int = 0
    var index: Int = 0
    var name: String = ""
    var code: Int = 0
}