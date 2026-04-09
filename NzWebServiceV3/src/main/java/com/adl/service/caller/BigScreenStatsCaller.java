package com.adl.service.caller;

import com.adl.service.callback.RequestCallback;
import com.adl.service.exception.NzBaseException;
import com.adl.service.web.request.BestRankTopRequest;
import com.adl.service.web.request.CompetitionRankRequest;
import com.adl.service.web.request.MorePeopleRecordRankRequest;
import com.adl.service.web.request.MorePeopleVictoryRankRequest;
import com.adl.service.web.request.OverviewRequest;
import com.adl.service.web.request.PersonRankRequest;
import com.adl.service.web.request.RequestScope;
import com.adl.service.web.request.SportRankRequest;
import com.adl.service.web.request.SumScoreRankRequest;
import com.adl.service.web.request.WarRecordRankRequest;
import com.adl.service.web.response.BestRankTopData;
import com.adl.service.web.response.CompetitionRankData;
import com.adl.service.web.response.ExerciseSumTimeRankData;
import com.adl.service.web.response.MorePeopleRecordRankData;
import com.adl.service.web.response.MorePeopleVictoryRankData;
import com.adl.service.web.response.OverviewData;
import com.adl.service.web.response.PersonRankData;
import com.adl.service.web.response.PhysicalTrainingRankData;
import com.adl.service.web.response.SportRankKingData;
import com.adl.service.web.response.SportSkuRankData;
import com.adl.service.web.response.SumScoreRankData;
import com.adl.service.web.response.WarRecordRankData;

import java.util.List;

/**
 * BigScreenStatsCaller。
 */
public interface BigScreenStatsCaller {

    long getWarRecordRankAsync(RequestScope scope, WarRecordRankRequest request, RequestCallback<List<WarRecordRankData>> callback);

    List<WarRecordRankData> getWarRecordRankSync(WarRecordRankRequest request) throws NzBaseException;

    long getPersonRankAsync(RequestScope scope, PersonRankRequest request, RequestCallback<PersonRankData> callback);

    PersonRankData getPersonRankSync(PersonRankRequest request) throws NzBaseException;

    long getMorePeopleVictoryRankAsync(RequestScope scope, MorePeopleVictoryRankRequest request, RequestCallback<List<MorePeopleVictoryRankData>> callback);

    List<MorePeopleVictoryRankData> getMorePeopleVictoryRankSync(MorePeopleVictoryRankRequest request) throws NzBaseException;

    long getMorePeopleRecordRankAsync(RequestScope scope, MorePeopleRecordRankRequest request, RequestCallback<List<MorePeopleRecordRankData>> callback);

    List<MorePeopleRecordRankData> getMorePeopleRecordRankSync(MorePeopleRecordRankRequest request) throws NzBaseException;

    long getOverviewAsync(RequestScope scope, OverviewRequest request, RequestCallback<OverviewData> callback);

    OverviewData getOverviewSync(OverviewRequest request) throws NzBaseException;

    long getCompetitionRankAsync(RequestScope scope, CompetitionRankRequest request, RequestCallback<CompetitionRankData> callback);

    CompetitionRankData getCompetitionRankSync(CompetitionRankRequest request) throws NzBaseException;

    long sumScoreRankAsync(RequestScope scope, SumScoreRankRequest request, RequestCallback<List<SumScoreRankData>> callback);

    List<SumScoreRankData> sumScoreRankSync(SumScoreRankRequest request) throws NzBaseException;

    long getSportSkuRankAsync(RequestScope scope, SportRankRequest request, RequestCallback<List<SportSkuRankData>> callback);

    List<SportSkuRankData> getSportSkuRankSync(SportRankRequest request) throws NzBaseException;

    long getSportRankKingAsync(RequestScope scope, SportRankRequest request, RequestCallback<List<SportRankKingData>> callback);

    List<SportRankKingData> getSportRankKingSync(SportRankRequest request) throws NzBaseException;

    long getPhysicalTrainingRankAsync(RequestScope scope, SportRankRequest request, RequestCallback<List<PhysicalTrainingRankData>> callback);

    List<PhysicalTrainingRankData> getPhysicalTrainingRankSync(SportRankRequest request) throws NzBaseException;

    long getExerciseSumTimeRankAsync(RequestScope scope, SportRankRequest request, RequestCallback<List<ExerciseSumTimeRankData>> callback);

    List<ExerciseSumTimeRankData> getExerciseSumTimeRankSync(SportRankRequest request) throws NzBaseException;

    long getBestRankTopAsync(RequestScope scope, BestRankTopRequest request, RequestCallback<List<BestRankTopData>> callback);

    List<BestRankTopData> getBestRankTopSync(BestRankTopRequest request) throws NzBaseException;

}
