/*
 * Copyright (C) 2012-2017 The Android Money Manager Ex Project Team
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.money.manager.ex.sync;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.money.manager.ex.R;
import com.money.manager.ex.common.events.ListItemClickedEvent;
import com.money.manager.ex.view.RobotoTextViewFontIcon;

import org.greenrobot.eventbus.EventBus;

/**
 * View holder for the cloud items (folder, file).
 */
public class CloudItemViewHolder
    extends RecyclerView.ViewHolder {

    public CloudItemViewHolder(View itemView) {
        super(itemView);

        initialize(itemView);
    }

    public int itemPosition;
    public String itemPath;
    // view elements
    public RobotoTextViewFontIcon nameTextView;

    private void initialize(View view) {
        // e clicks on the parent element
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new ListItemClickedEvent(itemPosition, itemPath, v));
            }
        });

        nameTextView = (RobotoTextViewFontIcon) view.findViewById(R.id.nameTextView);
    }
}
