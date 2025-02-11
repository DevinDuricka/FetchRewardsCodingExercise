package one.fable.fetchexercise

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform