import dayjs from 'dayjs';

export const getLabelByTypeDate = (typeDate) => {

    const currentDate = dayjs();

    switch (typeDate) {
        case 'Day':
            return Array.from(Array(currentDate.daysInMonth()).keys());
        case 'Month':
            return [...Array(12).keys()].map(element => element + 1);
        case 'Year':
            const year = currentDate.year();
            return [year - 2, year - 1, year];
    }
};

export const exportDataOrdersByTypeDate = (orders, typeDate) => {
    const labels = getLabelByTypeDate(typeDate);

    const dateOrdered = orders.map(order => dayjs(order.hd_ngaythanhtoan));

    if (typeDate === 'Day') {
        return labels.map(label => {
            const currentDate = dayjs();

            const day = dayjs(new Date(currentDate.year(), currentDate.month(), label + 1));

            const count = dateOrdered.filter(date => day.year() === date.year()
                && day.month() === date.month() && day.date() === date.date()).length;

            return count;
        })
    }
    else if (typeDate === 'Month') {
        return labels.map(label => {
            const currentDate = dayjs();

            const day = dayjs(new Date(currentDate.year(), label - 1, 1));

            const count = dateOrdered.filter((date => day.year() === date.year()
                && day.month() === date.month())).length;

            return count;
        })
    } else if (typeDate === 'Year') {
        return labels.map(label => {
            const currentDate = dayjs();

            const day = dayjs(new Date(label, currentDate.month(), 1));

            const count = dateOrdered.filter((date => day.year() === date.year())).length;

            return count;
        })
    }
}

export const exportTotalOrdersByTypeDate = (orders, typeDate) => {
    const labels = getLabelByTypeDate(typeDate);

    const dateOrdered = orders.map(order => ({
        'hd_ngaythanhtoan': dayjs(order.hd_ngaythanhtoan),
        'hd_tongtien': order.hd_tongtien
    }));

    console.log(dateOrdered)

    if (typeDate === 'Day') {
        return labels.map(label => {
            const currentDate = dayjs();

            const day = dayjs(new Date(currentDate.year(), currentDate.month(), label + 1));

            const count = dateOrdered.reduce((total, element) => {
                const { hd_ngaythanhtoan: date, hd_tongtien } = element;
                if (day.year() === date.year()
                    && day.month() === date.month()
                    && day.date() === date.date()) {
                    total += hd_tongtien;
                }

                return total;
            }, 0);

            return count;
        })
    }
    else if (typeDate === 'Month') {
        return labels.map(label => {
            const currentDate = dayjs();

            const day = dayjs(new Date(currentDate.year(), label - 1, 1));

            const count = dateOrdered.reduce((total, element) => {
                const { hd_ngaythanhtoan: date, hd_tongtien } = element;

                if (day.year() === date.year()
                    && day.month() === date.month()) {
                    total += hd_tongtien;
                }

                return total;
            }, 0);

            return count;
        })
    } else if (typeDate === 'Year') {
        return labels.map(label => {
            const currentDate = dayjs();

            const day = dayjs(new Date(label, currentDate.month(), 1));

            const count = dateOrdered.reduce((total, element) => {
                const { hd_ngaythanhtoan: date, hd_tongtien } = element;

                if (day.year() === date.year()) {
                    total += hd_tongtien;
                }

                return total;
            }, 0);

            return count;
        })
    }
}