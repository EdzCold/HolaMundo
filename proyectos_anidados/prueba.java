


    private static final int MOTOR_IM = 6814; // Look


            PackageManager packageManager = context.getPackageManager();

            String versionName;  //  registro produce
            PackageInfo packageInfo_MB; //  biometria
            PackageInfo packageInfo_CP; //  codigospostales
            PackageInfo packageInfo_IM; //  motor Imagen

            try {
                versionName = packageManager.getPackageInfo(context.getPackageName(),0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            
            try {
                packageInfo_MB = packageManager.getPackageInfo("com.profuturo.biometria", 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                showAlert(context.getResources().getString(R.string.titulo_profuturo), String.format(context.getResources().getString(R.string.app_not_found), context.getResources().getString(R.string.motor_biometrico)));
                return;
            }

            try {
                packageInfo_CP = packageManager.getPackageInfo("profuturo.com.codigospostales", 0);
             } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                showAlert(context.getResources().getString(R.string.titulo_profuturo), String.format(context.getResources().getString(R.string.app_not_found), context.getResources().getString(R.string.motor_cp)));
                return;
            }

            try {
                packageInfo_IM = packageManager.getPackageInfo("mx.com.profuturo.motor", 0);
             } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                showAlert(context.getResources().getString(R.string.titulo_profuturo), String.format(context.getResources().getString(R.string.app_not_found), context.getResources().getString(R.string.motor_cp)));
                return;
            }

            //---------------------------------------------------------------
                String version_MB = packageInfo_MB.versionName;
                String version_CP = packageInfo_CP.versionName;
                String version_IM = packageInfo_IM.versionName;
                
                for (JsonNode elemento : elementosArray) {
                    

                    if (elemento.get("idElemento").asInt() == PRODUCE_REGISTRO
                            && validateVersion(versionName, elemento.get("claveAlfanumerica").asText())) {
                        updated = true;
                        break;
                    }

                    if (elemento.get("idElemento").asInt() == MOTOR_BIOMETRICO
                            && validateVersion(version_MB,elemento.get("claveAlfanumerica").asText())) {
                        updatedMB = true;
                        break;
                    }

                    if (elemento.get("idElemento").asInt() == MOTOR_CP
                            && validateVersion(version_CP,elemento.get("claveAlfanumerica").asText())) {
                        updatedMCP = true;
                        break;
                    }

                    if (elemento.get("idElemento").asInt() == MOTOR_IM
                            && validateVersion(versionIM,elemento.get("claveAlfanumerica").asText())) {
                        updatedIM = true;
                        break;
                    }

                }

// ----------------------------------------------------------------------------------------------------- *********************************************************
                String versionName = packageInfo.versionName;
                for (JsonNode elemento : elementosArray) {
                    
                }
            

                String versionName = packageInfo.versionName;
                for (JsonNode elemento : elementosArray) {
                    
                }
           