package com.opendev.cn.instagram4android.requests;

import com.opendev.cn.instagram4android.InstagramConstants;
import com.opendev.cn.instagram4android.requests.payload.InstagramGetMediaCommentsResult;

import lombok.NonNull;

/**
 * Created by root on 09/06/17.
 */

public class InstagramGetMediaCommentsRequest extends InstagramGetRequest<InstagramGetMediaCommentsResult> {

    @NonNull
    private String mediaId;
    private String maxId;

    @Override
    public String getUrl() {
        String url = "media/" + mediaId + "/comments/?ig_sig_key_version=" + InstagramConstants.API_KEY_VERSION;
        if (maxId != null && !maxId.isEmpty()) {
            url += "&max_id=" + maxId;
        }
        return url;
    }

    @Override
    public InstagramGetMediaCommentsResult parseResult(int resultCode, String content) {
        return parseJson(resultCode, content, InstagramGetMediaCommentsResult.class);
    }
}
