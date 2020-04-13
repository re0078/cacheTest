package com.springTests.twoMongoDBTesting.entities

data class FromJsonData(val id: String, val integer: Int, val extraField: String, val redundant: String?) {
    override fun toString(): String {
        return "$id,$integer,$extraField,$redundant"
    }
}