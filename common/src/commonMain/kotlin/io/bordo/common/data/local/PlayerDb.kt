package io.bordo.common.data.local

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class PlayerDb : RealmObject {
    @PrimaryKey
    var id: Int = 0
    var firstName: String = ""
    var secondName: String = ""
    var code: Int = 0
    var teamCode: Int = 0
    var totalPoints: Int = 0
    var nowCost: Int = 0
    var goalsScored: Int = 0
    var assists: Int = 0
    var team: TeamDb? = null
}