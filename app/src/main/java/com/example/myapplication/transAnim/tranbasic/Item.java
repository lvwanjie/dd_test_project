/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.myapplication.transAnim.tranbasic;

/**
 * Represents an Item in our application. Each item has a name, id, full size image url and
 * thumbnail url.
 */
public class Item {

    private static final String LARGE_BASE_URL = "https://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/large/";
    private static final String THUMB_BASE_URL = "https://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/";

    public static Item[] ITEMS = new Item[] {
            new Item("Flying in the Light", "Romain Guy", "https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3879034635,3369355229&fm=26&gp=0.jpg"),
            new Item("Caterpillar", "Romain Guy", "https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1285218087,2754725246&fm=26&gp=0.jpg"),
            new Item("Look Me in the Eye", "Romain Guy", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2993266747,517049765&fm=26&gp=0.jpg"),
            new Item("Flamingo", "Romain Guy", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1371606447,4035490053&fm=26&gp=0.jpg"),
            new Item("Rainbow", "Romain Guy", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3175078226,377676635&fm=26&gp=0.jpg"),
            new Item("Over there", "Romain Guy", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1670573789,3903378887&fm=26&gp=0.jpg"),
            new Item("Jelly Fish 2", "Romain Guy", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2523658414,1890673399&fm=26&gp=0.jpg"),
            new Item("Lone Pine Sunset", "Romain Guy", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3802549374,3227528753&fm=26&gp=0.jpg"),
    };

    public static Item getItem(int id) {
        for (Item item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private final String mName;
    private final String mAuthor;
    private final String mFileName;

    Item (String name, String author, String fileName) {
        mName = name;
        mAuthor = author;
        mFileName = fileName;
    }

    public int getId() {
        return mName.hashCode() + mFileName.hashCode();
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getName() {
        return mName;
    }

    public String getPhotoUrl() {
        return LARGE_BASE_URL + mFileName;
    }

    public String getThumbnailUrl() {
        return  mFileName;
    }

}
