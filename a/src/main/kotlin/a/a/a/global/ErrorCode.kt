package a.a.a.global

enum class ErrorCode (
    val msg: String,
    val code: Int
) {
    UNATHORIZED("권한 필요", 401);
}