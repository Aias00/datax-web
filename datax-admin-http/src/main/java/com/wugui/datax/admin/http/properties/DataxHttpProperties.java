package com.wugui.datax.admin.http.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.serializer.Serializer;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author liuhy
 * @since 2022/5/10
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ConfigurationProperties(prefix = "datax.job.admin")
public class DataxHttpProperties implements Serializable {
    private static final long serialVersionUID = 4734495947269306920L;

    private String address;
//    private String addresses;
    private String username;
    private String password;
}
