################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../link_list.c \
../main.c \
../queue.c \
../stack.c \
../utils.c 

OBJS += \
./link_list.o \
./main.o \
./queue.o \
./stack.o \
./utils.o 

C_DEPS += \
./link_list.d \
./main.d \
./queue.d \
./stack.d \
./utils.d 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o"$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


