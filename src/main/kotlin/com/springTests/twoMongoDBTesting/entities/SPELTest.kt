package com.springTests.twoMongoDBTesting.entities

data class SPELTest(val id: Int, val extra: Int) {

    override fun equals(other: Any?): Boolean {
        return other is SPELTest && other.id == id/* && other.extra == extra*/
    }
}