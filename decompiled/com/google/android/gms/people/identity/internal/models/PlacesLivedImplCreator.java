package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl;
import com.google.android.gms.people.identity.internal.models.PersonImpl.PlacesLivedImpl;
import com.google.wireless.android.play.playlog.proto.UserLocation.OvenFreshEvent.OvenFreshResult;
import com.google.wireless.android.play.playlog.proto.UserLocation.TimeSelection.Type;
import java.util.HashSet;
import java.util.Set;

public class PlacesLivedImplCreator implements Creator<PlacesLivedImpl> {
    public static final int CONTENT_DESCRIPTION = 0;

    public PlacesLivedImpl createFromParcel(Parcel parcel) {
        int end = SafeParcelReader.validateObjectHeader(parcel);
        Set<Integer> _local_safe_0a1b_mIndicatorSet = new HashSet();
        int _local_safe_0a1b_mVersionCode = 0;
        MetadataImpl _local_safe_0a1b_mMetadata = null;
        boolean _local_safe_0a1b_mCurrent = false;
        String _local_safe_0a1b_mValue = null;
        while (parcel.dataPosition() < end) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case Type.TEMPORARY /*1*/:
                    _local_safe_0a1b_mVersionCode = SafeParcelReader.readInt(parcel, header);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(1));
                    break;
                case Type.INDEFINITELY /*2*/:
                    _local_safe_0a1b_mMetadata = (MetadataImpl) SafeParcelReader.createParcelable(parcel, header, MetadataImpl.CREATOR);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(2));
                    break;
                case Type.CUSTOM /*3*/:
                    _local_safe_0a1b_mCurrent = SafeParcelReader.readBoolean(parcel, header);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(3));
                    break;
                case OvenFreshResult.NO_ACCOUNTS /*4*/:
                    _local_safe_0a1b_mValue = SafeParcelReader.createString(parcel, header);
                    _local_safe_0a1b_mIndicatorSet.add(Integer.valueOf(4));
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        if (parcel.dataPosition() == end) {
            return new PlacesLivedImpl(_local_safe_0a1b_mIndicatorSet, _local_safe_0a1b_mVersionCode, _local_safe_0a1b_mMetadata, _local_safe_0a1b_mCurrent, _local_safe_0a1b_mValue);
        }
        throw new ParseException("Overread allowed size end=" + end, parcel);
    }

    public PlacesLivedImpl[] newArray(int size) {
        return new PlacesLivedImpl[size];
    }

    static void writeToParcel(PlacesLivedImpl obj, Parcel parcel, int flags) {
        int myStart = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> __setFields = obj.mIndicatorSet;
        if (__setFields.contains(Integer.valueOf(1))) {
            SafeParcelWriter.writeInt(parcel, 1, obj.mVersionCode);
        }
        if (__setFields.contains(Integer.valueOf(2))) {
            SafeParcelWriter.writeParcelable(parcel, 2, obj.mMetadata, flags, true);
        }
        if (__setFields.contains(Integer.valueOf(3))) {
            SafeParcelWriter.writeBoolean(parcel, 3, obj.mCurrent);
        }
        if (__setFields.contains(Integer.valueOf(4))) {
            SafeParcelWriter.writeString(parcel, 4, obj.mValue, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, myStart);
    }
}
