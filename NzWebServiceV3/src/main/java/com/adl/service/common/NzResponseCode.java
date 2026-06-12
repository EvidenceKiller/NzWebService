package com.adl.service.common;

public interface NzResponseCode {
    int NZ_SUCCESS = 200;

    int NZ_SERVER_ERROR = 500;

    int NZ_UPLOAD_REPEAT_ID_ERROR = 10100105;

    int NZ_DIRTY_DATA_ERROR = 50000;

    int NZ_UNKNOWN_ERROR = -1000;

    int NZ_NO_DATA_ERROR = -1001;

    int NZ_NETWORK_ERROR = -1002;

    int NZ_CONNECT_ERROR = -1003;

    int NZ_TIMEOUT_ERROR = -1004;

    int NZ_IO_ERROR = -1005;

    int NZ_INTERRUPTED_ERROR = -1006;

    int NZ_JSON_PARSE_ERROR = -1007;

    int NZ_FETCH_PAGE_ERROR = -1008;

    int NZ_DOWNLOAD_FILE_ERROR = -1009;

    int NZ_PERSIST_ERROR = -1010;

}
