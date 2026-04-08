package com.adl.service.v3interface.out;

import com.adl.service.v3interface.api.RequestScope;
import com.adl.service.v3interface.callback.RequestCallback;
import com.adl.service.v3interface.request.BestRankTopRequest;
import com.adl.service.v3interface.request.CompetitionRankRequest;
import com.adl.service.v3interface.request.MorePeopleRecordRankRequest;
import com.adl.service.v3interface.request.MorePeopleVictoryRankRequest;
import com.adl.service.v3interface.request.OverviewRequest;
import com.adl.service.v3interface.request.PersonRankRequest;
import com.adl.service.v3interface.request.SportRankRequest;
import com.adl.service.v3interface.request.SumScoreRankRequest;
import com.adl.service.v3interface.request.WarRecordRankRequest;
import com.adl.service.v3interface.response.BestRankTopData;
import com.adl.service.v3interface.response.CompetitionRankData;
import com.adl.service.v3interface.response.ExerciseSumTimeRankData;
import com.adl.service.v3interface.response.MorePeopleRecordRankData;
import com.adl.service.v3interface.response.MorePeopleVictoryRankData;
import com.adl.service.v3interface.response.OverviewData;
import com.adl.service.v3interface.response.PersonRankData;
import com.adl.service.v3interface.response.PhysicalTrainingRankData;
import com.adl.service.v3interface.response.SportRankKingData;
import com.adl.service.v3interface.response.SportSkuRankData;
import com.adl.service.v3interface.response.SumScoreRankData;
import com.adl.service.v3interface.response.WarRecordRankData;

import java.util.List;

/**
 * BigScreenStatsCaller。
 */
public interface BigScreenStatsCaller {

    long getWarRecordRankAsync(RequestScope scope, WarRecordRankRequest request, RequestCallback<List<WarRecordRankData>> callback);

    List<WarRecordRankData> getWarRecordRankSync(WarRecordRankRequest request);

    long getPersonRankAsync(RequestScope scope, PersonRankRequest request, RequestCallback<PersonRankData> callback);

    PersonRankData getPersonRankSync(PersonRankRequest request);

    long getMorePeopleVictoryRankAsync(RequestScope scope, MorePeopleVictoryRankRequest request, RequestCallback<List<MorePeopleVictoryRankData>> callback);

    List<MorePeopleVictoryRankData> getMorePeopleVictoryRankSync(MorePeopleVictoryRankRequest request);

    long getMorePeopleRecordRankAsync(RequestScope scope, MorePeopleRecordRankRequest request, RequestCallback<List<MorePeopleRecordRankData>> callback);

    List<MorePeopleRecordRankData> getMorePeopleRecordRankSync(MorePeopleRecordRankRequest request);

    long getOverviewAsync(RequestScope scope, OverviewRequest request, RequestCallback<OverviewData> callback);

    OverviewData getOverviewSync(OverviewRequest request);

    long getCompetitionRankAsync(RequestScope scope, CompetitionRankRequest request, RequestCallback<CompetitionRankData> callback);

    CompetitionRankData getCompetitionRankSync(CompetitionRankRequest request);

    long sumScoreRankAsync(RequestScope scope, SumScoreRankRequest request, RequestCallback<List<SumScoreRankData>> callback);

    List<SumScoreRankData> sumScoreRankSync(SumScoreRankRequest request);

    long getSportSkuRankAsync(RequestScope scope, SportRankRequest request, RequestCallback<List<SportSkuRankData>> callback);

    List<SportSkuRankData> getSportSkuRankSync(SportRankRequest request);

    long getSportRankKingAsync(RequestScope scope, SportRankRequest request, RequestCallback<List<SportRankKingData>> callback);

    List<SportRankKingData> getSportRankKingSync(SportRankRequest request);

    long getPhysicalTrainingRankAsync(RequestScope scope, SportRankRequest request, RequestCallback<List<PhysicalTrainingRankData>> callback);

    List<PhysicalTrainingRankData> getPhysicalTrainingRankSync(SportRankRequest request);

    long getExerciseSumTimeRankAsync(RequestScope scope, SportRankRequest request, RequestCallback<List<ExerciseSumTimeRankData>> callback);

    List<ExerciseSumTimeRankData> getExerciseSumTimeRankSync(SportRankRequest request);

    long getBestRankTopAsync(RequestScope scope, BestRankTopRequest request, RequestCallback<List<BestRankTopData>> callback);

    List<BestRankTopData> getBestRankTopSync(BestRankTopRequest request);

}
