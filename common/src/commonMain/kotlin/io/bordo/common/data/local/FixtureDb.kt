package io.bordo.common.data.local

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class FixtureDb : RealmObject {
    @PrimaryKey
    var id: Int = 0
    var kickoffTime: String? = ""
    var homeTeam: TeamDb? = null
    var awayTeam: TeamDb? = null
    var homeTeamScore: Int = 0
    var awayTeamScore: Int = 0
    var event: Int = 0
}