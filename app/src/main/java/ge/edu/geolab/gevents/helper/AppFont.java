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
    BPG_NINO_MKHEDRULI_NORMAL {
        @Override
        public String getFileName() {
            return "bpg_nino_mkhedruli_normal.ttf";
        }
    },
    BPG_ALGETI {
        @Override
        public String getFileName() {
            return "bpg_algeti.ttf";
        }
    },
    ARIAL {
        @Override
        public String getFileName() {
            return "arial.ttf";
        }
    },
    DEJAVU_SANS_EXTRA_LIGHT {
        @Override
        public String getFileName() {
            return "dejavu-sans-extra-light.ttf";
        }
    };

    @Override
    public String getFilePath() {
        return "fonts/" + getFileName();
    }
}
