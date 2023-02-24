package com.atabs.atabbe.model;

import java.util.Map;

public class ReportDetailDto {

            private String format;

            private String module;

            private String filename;

            private Map<String, Object> params;

            public String getFormat() {
                return format;
            }

           public void setFormat(String format) {
                this.format = format;
           }

            public String getModule() {
                return module;
            }

            public void setModule(String module) {
                this.module = module;
            }

           public String getFilename() {
                return filename;
            }
            public void setFilename(String filename) {
                this.filename = filename;
           }

            public Map<String, Object> getParams() {
                return params;
           }

            public void setParams(Map<String, Object> params) {
                this.params = params;
           }
}
