package ge.edu.geolab.gevents.helper;

import ge.edu.geolab.gevents.helper.font.IFont;

/**
 * Created by akaki on 05.02.17.
 */

public enum AppFont implements IFont {
    BPG_NINO_MTAVRULI_NORMAL {
        @Override
        public String getFileName() {
            return "bpg_nino_mtavruli_normal.ttf";
        }
    },
    ARIAL {
        @Override
        public String getFileName() {
            return "arial.ttf";
        }
    };

    @Override
    public String getFilePath() {
        return "fonts/" + getFileName();
    }
}
