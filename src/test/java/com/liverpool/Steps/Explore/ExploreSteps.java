package com.liverpool.Steps.Explore;

import com.liverpool.Actor.I;
import com.liverpool.Pages.Explore.ExplorePage;
import com.liverpool.Pages.Explore.ExploreFirstSubsectionsPage;
import com.liverpool.Pages.Explore.ExploreSecondSubsectionPage;
import io.cucumber.java.en.And;

public class ExploreSteps {

    @And("^explore section (WOMAN|MAN|ELECTRONIC|HOME)$")
    public void explore_section(String _exploreSection) {
        ExplorePage explorePage = I.get().initPage(ExplorePage.class);
        explorePage.exploreSection(_exploreSection);
    }

    @And("^explore electronic subsection (PHONES|TV_AND_VIDEO|COMPUTING|AUDIO|CAMERAS|GAMING)$")
    public void explore_electronic_subsection(String _exploreSubsection) {
        ExploreFirstSubsectionsPage exploreFirstSubsectionsPage = I.get().initPage(ExploreFirstSubsectionsPage.class);
        exploreFirstSubsectionsPage.exploreElectronicSubsection(_exploreSubsection);
    }

    @And("^explore gaming subsection (PC_GAMER|LAPTOP_GAMER)$")
    public void explore_gaming_subsection(String _exploreSubsection) {
        ExploreSecondSubsectionPage exploreSecondSubsectionPage = I.get().initPage(ExploreSecondSubsectionPage.class);
        exploreSecondSubsectionPage.exploreGamingSubsection(_exploreSubsection);
    }
}