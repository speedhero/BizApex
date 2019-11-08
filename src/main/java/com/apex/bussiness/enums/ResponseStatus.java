package com.apex.bussiness.enums;

/**
 * @author rick jiang (speedhero@126.com)
 * @website https://www.zhyd.me
 * @version 1.0
 * @date 2019/4/16 16:26
 * @since 1.0
 */
public enum ResponseStatus {

    SUCCESS(200, "操作成功！"),
    ERROR(500, "服务器未知错误！"),
    INVALID_PARAMS(500, "操作失败无效的参数！"),
    UPLOAD_FILE_ERROR(500, "文件上传失败！"),
    ;

    private Integer code;
    private String message;

    ResponseStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseStatus getResponseStatus(String message) {
        for (ResponseStatus ut : ResponseStatus.values()) {
            if (ut.getMessage() == message) {
                return ut;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
