/**
 * Created by davi on 2017/7/16.
 */
@GenericGenerator(name = "ID_GENERATOR", strategy = "enhanced-table",
        parameters = {@Parameter(name = "seq_name",value = "ww"),
                @Parameter(name = "next_val",value = "1")})
package com.kfit.core.bean;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;