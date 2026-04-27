package com.adl.service.repository.prepare;

import android.text.TextUtils;

import com.adl.service.data.CompetitionData;
import com.adl.service.data.SportMeetData;
import com.adl.service.db.DaoManagerProxy;
import com.adl.service.http.request.CompetitionPageRequest;
import com.adl.service.http.request.SportMeetPageRequest;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public final class BusinessPrepareHelper {

    public BusinessPrepareHelper() {
    }

    public Function<CompetitionPageRequest, Single<List<CompetitionData>>> createPrepareCompetitionPageFunc() {
        return (request) -> {
            DaoManagerProxy.getInstance().getCompetitionDao().clearAll();
            return null;
        };
    }

    public Function<SportMeetPageRequest, Single<List<SportMeetData>>> createPrepareSportMeetPageFunc() {
        return (request) -> {
            if (TextUtils.isEmpty(request.getAppCode())) {
                DaoManagerProxy.getInstance().getSportMeetDao().clearAll();
                DaoManagerProxy.getInstance().getSportMeetGroupTeamDao().clearAll();
                DaoManagerProxy.getInstance().getSportMeetGroupDetailsDao().clearAll();
            } else {
                DaoManagerProxy.getInstance().getSportMeetDao().clearByAppCode(request.getAppCode());
                DaoManagerProxy.getInstance().getSportMeetGroupTeamDao().clearByAppCode(request.getAppCode());
                DaoManagerProxy.getInstance().getSportMeetGroupDetailsDao().clearByAppCode(request.getAppCode());
            }
            return null;
        };
    }
}
