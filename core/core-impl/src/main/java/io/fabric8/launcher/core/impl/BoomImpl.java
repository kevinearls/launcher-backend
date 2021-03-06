package io.fabric8.launcher.core.impl;

import java.util.List;

import io.fabric8.launcher.core.api.Boom;
import io.fabric8.launcher.service.github.api.GitHubRepository;
import io.fabric8.launcher.service.github.api.GitHubWebhook;
import io.fabric8.launcher.service.openshift.api.OpenShiftProject;

/**
 * @author <a href="mailto:alr@redhat.com">Andrew Lee Rubinger</a>
 */
public final class BoomImpl implements Boom {

    /**
     * Creates a new instance with the specified, required {@link GitHubRepository}
     * and {@link OpenShiftProject}
     *
     * @param gitHubRepository the forked repository on GitHub. Required
     * @param openShiftProject the project created on OpenShift. Required
     * @param webhook          the webhook created on the forked repo on GitHub to trigger builds on OpenShift. Optional
     */
    BoomImpl(final GitHubRepository gitHubRepository, final OpenShiftProject openShiftProject, final List<GitHubWebhook> webhooks) {
        assert gitHubRepository != null : "gitHubRepository must be specified";
        assert openShiftProject != null : "openShiftProject must be specified";
        this.gitHubRepository = gitHubRepository;
        this.openShiftProject = openShiftProject;
        this.webhooks = webhooks;
    }

    private final GitHubRepository gitHubRepository;

    private final OpenShiftProject openShiftProject;

    private final List<GitHubWebhook> webhooks;

    @Override
    public GitHubRepository getCreatedRepository() {
        return this.gitHubRepository;
    }

    @Override
    public OpenShiftProject getCreatedProject() {
        return this.openShiftProject;
    }

    @Override
    public List<GitHubWebhook> getGitHubWebhooks() {
        return this.webhooks;
    }
}
